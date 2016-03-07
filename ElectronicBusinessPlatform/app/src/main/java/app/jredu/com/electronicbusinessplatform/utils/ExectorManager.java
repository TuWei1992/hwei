package app.jredu.com.electronicbusinessplatform.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2015/10/14 0014.
 */
public class ExectorManager {
    /**
     * 单例模式
     */
    //提供静态常量，存储数据
    private static ExectorManager instance;
    public static ExectorManager getInstance(){

        if(instance==null){//判断是否第一次调用
            synchronized (ExectorManager.class) {
                if(instance==null){
                    instance=new ExectorManager();
                }
            }
            instance=new ExectorManager();
        }
        return instance;
    }


    //定义线程执行器
    private ExecutorService executorService;
    //私有化构造函数
    private ExectorManager(){
        inti();
    }
    private void inti(){
        //初始化线程池
        int max=8;
        int num=Runtime.getRuntime().availableProcessors()*2+1;
        num=num>max?max:num;
        executorService= Executors.newFixedThreadPool(num);
    }
    /**
     * 执行任务
     * @param runnable
     */
    public void execute(Runnable runnable){
        this.executorService.execute(runnable);
    }

    public ExecutorService getExectors(){
        return this.executorService;
    }
}
