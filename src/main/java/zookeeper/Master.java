package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Random;

public class Master implements Watcher {
    private ZooKeeper zk;
    private String host;
    private String serverId=Integer.toHexString(new Random().nextInt());
    private static boolean isLeader;

    public Master(String host) {
        this.host = host;
    }

    private void startZK(){
        try {
            zk=new ZooKeeper(host,15000,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopZK(){
        try {
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private boolean checkMaster(){
        while (true){
            try {
                Stat stat=new Stat();
                byte data[]=zk.getData("/master",false,stat);
                isLeader=new String(data).equals(serverId);
                return true;
            } catch (KeeperException e) {
                e.printStackTrace();
                return false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void runForMaster(){
        while (true) {
            try {
                zk.create("/master",
                        serverId.getBytes(),
                        ZooDefs.Ids.OPEN_ACL_UNSAFE,
                        CreateMode.EPHEMERAL);
                isLeader=true;
                break;
            } catch (KeeperException e) {
                e.printStackTrace();
                isLeader=false;
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (checkMaster()) break;
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public static void main(String[] args) {
        Master master=new Master("120.79.91.4:2181");
        master.startZK();
        master.runForMaster();
        try {
            if (isLeader) {
                System.out.println("I'm the leader");
                Thread.sleep(60000);
            } else {
                System.out.println("Someone else is the leader");
            }
            master.stopZK();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
