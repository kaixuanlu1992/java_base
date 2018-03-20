package zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

public class Basic implements Watcher {
    private ZooKeeper zk;
    private String host;

    public Basic(String host) {
        this.host = host;
    }

    private void start() throws IOException {
        zk=new ZooKeeper(host,15000,this);
    }

    private void stop() throws InterruptedException {
        zk.close();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public static void main(String[] args) throws IOException {
        Basic zk=new Basic("120.79.91.4:2181");
        zk.start();
        zk.createZnode("/master1","i am the master");
        try {
            System.out.println(zk.exists("/master1"));
            System.out.println(zk.getData("/master1"));
            zk.sych("/master1");
            zk.createZnode("/master2","i am the master");

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void createZnode(String path,String data){
        try {
            zk.create(path,data.getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,//ACL
                    CreateMode.EPHEMERAL);//模式
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean exists(String path) throws KeeperException, InterruptedException {

            return  zk.exists(path,this) != null;
    }

    private String getData(String path) throws KeeperException, InterruptedException {
        return new String(zk.getData(path,this,zk.exists(path,this)));
    }

    private void sych(String path){
        zk.sync(path, new MyVoidCallback(),"abs");
    }


}
class MyVoidCallback implements AsyncCallback.VoidCallback{

    @Override
    public void processResult(int i, String s, Object o) {
        System.out.println("异步结果"+i+"节点"+s+"上下文"+o);
    }
}
