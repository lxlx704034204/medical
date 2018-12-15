package com.bben.medical.controller;

import com.bben.medical.config.RedisTemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.concurrent.TimeUnit;

@Controller
public class HelloWorldController {
    private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);
    private static final long LOCK_TIMEOUT = 60 * 1000; //加锁超时时间 单位毫秒  意味着加锁期间内执行完操作 如果未完成会有并发现象

    @Autowired
    RedisTemplateUtil redisTemplateUtil;

    @RequestMapping("/sayhello.html")
    public @ResponseBody
    String say() {
        return "hello world";
    }

    @RequestMapping("/say.html")
    public @ResponseBody
    String say(String name) {
        redisTemplateUtil.set("abc", "1111");
        System.out.println("redisTemplateUtil value:" + redisTemplateUtil.get("abc"));
        boolean xxx = redisTemplateUtil.setNX("testKey", "ddddd");

        System.out.println("redisTemplateUtil xxx1:" + xxx);
        xxx = redisTemplateUtil.setNX("testKey", "ddddd");

        System.out.println("redisTemplateUtil xxx2:" + xxx);

        xxx = redisTemplateUtil.setNX("testKey", "ddddd");

        System.out.println("redisTemplateUtil xxx3:" + xxx);

        long timxxx = redisTemplateUtil.getTimeFromRedis();

        System.out.println("redisTemplateUtil timxxx1:" + timxxx);

        timxxx = redisTemplateUtil.getTimeFromRedis();

        System.out.println("redisTemplateUtil timxxx2:" + timxxx);

        timxxx = redisTemplateUtil.getTimeFromRedis();

        System.out.println("redisTemplateUtil timxxx3:" + timxxx);

        return "hello world " + name;
    }

    public Long lock(String lockKey, String threadname) {
        log.info(threadname + "开始执行加锁");
        while (true) { //循环获取锁
            Long lock_timeout = redisTemplateUtil.getTimeFromRedis() + LOCK_TIMEOUT + 1; //锁时间

            if (redisTemplateUtil.setNX(lockKey, lock_timeout)) { //如果加锁成功
                log.info(threadname + "加锁成功++++++++111111111");
                redisTemplateUtil.expire_milliseconds(lockKey, LOCK_TIMEOUT); //设置超时时间，释放内存
                return lock_timeout;
            } else {
                Long currt_lock_timeout_Str = (Long) redisTemplateUtil.get(lockKey); // redis里的时间
                if (currt_lock_timeout_Str != null && currt_lock_timeout_Str < System.currentTimeMillis()) { //锁已经失效
                    // 判断是否为空，不为空的情况下，说明已经失效，如果被其他线程设置了值，则第二个条件判断是无法执行

                    Long old_lock_timeout_Str = (Long) redisTemplateUtil.getAndSet(lockKey, lock_timeout);
                    // 获取上一个锁到期时间，并设置现在的锁到期时间
                    if (old_lock_timeout_Str != null && old_lock_timeout_Str.equals(currt_lock_timeout_Str)) {
                        // 如过这个时候，多个线程恰好都到了这里，但是只有一个线程的设置值和当前值相同，他才有权利获取锁
                        log.info(threadname + "加锁成功+++++++2222222222");
                        redisTemplateUtil.expire_milliseconds(lockKey, LOCK_TIMEOUT); //设置超时时间，释放内存
                        return lock_timeout;//返回加锁时间
                    }
                }
            }

            try {
                log.info(threadname + "等待加锁，睡眠100毫秒");
                TimeUnit.MILLISECONDS.sleep(100);//睡眠100毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void unlock(String lockKey, long lockvalue, String threadname) {
        log.info(threadname + "执行解锁==========");//正常直接删除 如果异常关闭判断加锁会判断过期时间
        Long currt_lock_timeout_Str = (Long) redisTemplateUtil.get(lockKey); // redis里的时间

        if (currt_lock_timeout_Str != null && currt_lock_timeout_Str == lockvalue) {//如果是加锁者 则删除锁 如果不是则等待自动过期 重新竞争加锁
            redisTemplateUtil.del(lockKey); //删除键
            log.info(threadname + "解锁成功-----------------");
        }
    }

    @RequestMapping("/testRedis")
    public @ResponseBody
    String testRedis(String name) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    task(Thread.currentThread().getName());
                }
            }).start();
        }

        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("redisTemplateUtil value:" + redisTemplateUtil.get("abc"));
        return "hello world " + name;
    }

    public void task(String name) {
        Long locktime; //加锁时间
        if ((locktime = lock("testKey" + 1, name)) != null) {
            //开始执行任务
            System.out.println(name + "任务执行中");
            //任务执行完毕 关闭锁
            unlock("testKey" + 1, locktime, name);
        }
    }

    @RequestMapping(value = "/testDownload", method = RequestMethod.GET)
    public void testDownload(HttpServletResponse res) {
        String fileName = "upload.jpg";
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File("d://" + fileName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null)
            {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
    }


    @RequestMapping(value = "/testDownload2/{fileName}", method = RequestMethod.GET)
    public void testDownload2(HttpServletResponse res, @PathVariable("fileName") String fileName) {
//        String fileName = "upload.jpg";
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File("d://" + fileName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null)
            {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
    }
}
