//package com.ethanzyc.allinone;
//
//import com.ciyun.appfanli.cache.SystemConfig;
//import com.ciyun.appfanli.entity.AsyncObject;
//import com.ciyun.appfanli.entity.UserFormid;
//import com.ciyun.appfanli.service.UserPigService;
//import com.ciyun.appfanli.util.ErrorUtil;
//import com.ciyun.appfanli.util.S11Util;
//import com.ciyun.appfanli.util.lru.LruCache;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.ApplicationContext;
//
//import java.util.concurrent.ConcurrentLinkedQueue;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;
//
//@Slf4j
//public class SqlUpdateThread implements Runnable {
//    private volatile boolean stop;
//    //private DiskQueue 			queue =   null;// new ConcurrentLinkedQueue<String>();;
//    ConcurrentLinkedQueue<AsyncObject> queueMem = new ConcurrentLinkedQueue<AsyncObject>();
//
//    //private thread											bindThread;
//
//
//    private static int UPDATE_DURATION = 200;
//    /**
//     * 更新器最小休眠时间
//     */
//    private static int MIN_SLEEP_TIME = 80;
//
//    /**
//     * 更新器每10秒执行的次数
//     */
//    private static int EXECUTE_TIME_PER_SEC = 1000 / UPDATE_DURATION;
//    /**
//     * 每秒总共完成的插入/更新操作数
//     */
//    private static int TOTAL_OPERATION_NUM_PER_SEC = 1000;
//
//    /**
//     * 每次更新的操作数个数
//     */
//    private static int EXECUTE_NUM_PER_TIME = TOTAL_OPERATION_NUM_PER_SEC / EXECUTE_TIME_PER_SEC;
//
//
//    /**
//     * 用于执行更新的线程池
//     */
//    private ExecutorService service;
//    //static  Map<String,AsyncObject> map = new ConcurrentHashMap<String,AsyncObject>();
//
//
//    public static SqlUpdateThread sqlUpdate;
//
//    public static SqlUpdateThread getInstance() {
//        if (sqlUpdate == null) {
//            init();
//        }
//        return sqlUpdate;
//    }
//
////    private UserPigService userPigService;
//
//    public SqlUpdateThread() {
////        ApplicationContext context =
//        ApplicationContext context = (ApplicationContext) SystemConfig.getInstance().getObject("ApplicationContext");
//
//        if (context != null) {
////            userPigService = context.getBean(UserPigService.class);
//
//
//        }
//    }
//
//    public static synchronized void init() {
//
//
//        sqlUpdate = new SqlUpdateThread();
//
//        sqlUpdate.start(null);
//    }
//
//    /**
//     * 使用指定线程池启动更新器。
//     *
//     * @param service 如果该值为null。那么本类会创建一个新的线程池并自己管理（stop方法）。
//     *                如果该值不为null。那么本类仅用这个线程池来启动更新器，stop方法对线程池没任何影响。
//     */
//    public void start(ExecutorService service) {
//        if (service == null) {
//            service = Executors.newFixedThreadPool(1);
//            this.service = service;
//        }
//        service.execute(this);
//        stop = false;
//    }
//
//    /**
//     * 关闭更新器。 该操作一旦执行，将停止接收新的更新数据，而且会一次性将队列中的数据更新到数据库。
//     * 如果在指定时间内，没有将队列中的数据更新到数据库，那么将直接退出，并打印错误日志。
//     */
//    public void stop(long timeout, TimeUnit unit) {
//        stop = true;
//        if (service != null) { // 自己管理的线程池
//            service.shutdown();
//            try {
//				/*logger.info("#######################################");
//				logger.info("# AsyncUpdateService Info             #");
//				logger.info("#######################################");
//				logger.info("Before stop AsyncUpdateService the size of queue is " + queue.size());
//				*/
//                boolean awaitTermination = service.awaitTermination(timeout,
//                        unit);
//                if (awaitTermination) {
//                    //logger.info("AsyncUpdateService exit successfully.");
//                } else {
//                    //logger.error("AsyncUpdateService exit faild, there are already following datas in queue : size=" + queue.size() + ", datas=" + queue.toString());
//                    service.shutdownNow();
//                }
//            } catch (InterruptedException e) {
//                //logException("AsyncUpdateServcice", e);
//            } finally {
//                //logger.info("After stop AsyncUpdateService the size of queue is " + queue.size());
//                //logger.info("#######################################");
//            }
//        }
//    }
//
//    /**
//     * 关闭更新器，使用默认超时退出。60秒。
//     */
//    public void stop() {
//        stop(60, TimeUnit.SECONDS);
//    }
//
//    /**
//     * @param asyncObject
//     */
//    public void addQueue(AsyncObject asyncObject) {
//		/*
//		if(map.containsKey(key)){
//			map.remove(key);
//			this.queue.remove(key);
//		}
//		map.put(key, asyncObject);*/
//        if (asyncObject.getType() == 107) {
//            if (S11Util.isS11()) {
//                return;
//            }
//        }
//        this.queueMem.add(asyncObject);
//    }
//
//    LruCache<Long, Long> userUpdateLru = new LruCache<>(10);
//    LruCache<Long, Boolean> userDailiLru = new LruCache<>(10);
//
//    public void clearLruCache() {
//        userUpdateLru.clear();
//        userDailiLru.clear();
//
//    }
//
//    public void proAsyn(AsyncObject asyncObj) {
//        if (asyncObj.getType() == 10) {
//            UserFormid userFormid = (UserFormid) asyncObj.getAsyncEntity();
//            userPigService.saveUserFormId(userFormid.getUserid(), userFormid.getFormId());
//        }
//    }
//
//    public void run() {
//        while (true) {
//            long startTime = 0;
//            int num = 0;
//            AsyncObject asyncObj = null;
//            byte[] b = null;
//            while ((asyncObj = queueMem.poll()) != null) {
//                try {
//                    //执行
//                    //	asyncObj = JSON.parseObject(b, AsyncObject.class);
//                    proAsyn(asyncObj);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                    logger.error(ErrorUtil.getError(ex));
//                    if (asyncObj.retry()) {
//                        //失败添加
//                        //	this.addQueue(asyncObj);
//                    }
//                }
//
//                if (num++ > EXECUTE_NUM_PER_TIME) {
//                    break;
//                }
//            }
//
//            if (stop) {
//                /*
//                 * 如果已经关闭了更新服务，而且队列中已经没有数据，那么退出。
//                 */
//                //if (queue.isEmpty()) {
//                //}
//                break;
//            } else {
//                /*
//                 * 休眠一段时间，等待下次更新。
//                 */
//                startTime = System.currentTimeMillis() - startTime; // 计算本次更新耗时
//                startTime = UPDATE_DURATION - startTime; // 本次剩余休眠时间
//                startTime = startTime < MIN_SLEEP_TIME ? MIN_SLEEP_TIME : startTime;
//                try {
//                    thread.sleep(startTime);
//                } catch (InterruptedException e) {
//
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        SqlUpdateThread sqlUpdate = new SqlUpdateThread();
//
//        int i = 0;
//        System.out.println(i++);
//        System.out.println(++i);
//        sqlUpdate.start(null);
//    }
//}
