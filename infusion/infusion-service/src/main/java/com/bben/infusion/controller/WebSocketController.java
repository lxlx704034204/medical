package com.bben.infusion.controller;
import com.bben.infusion.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.*;

@Controller
@RequestMapping()
public class WebSocketController {
    @GetMapping("/infusion")
    public String webSocket() throws IOException {
        return "webSocket";
    }

    @GetMapping("/call")
    public String webSocketTest() throws IOException {
        return "webSocket1";
    }

    @RequestMapping(value = "/voice/{date}/{name}", method = RequestMethod.GET)
    public void voice(HttpServletResponse res,@PathVariable("date") String date, @PathVariable("name") String name) throws IOException {
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + name);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(Constants.voicesPath +File.separator+date+File.separator + name)));
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
    }
}
