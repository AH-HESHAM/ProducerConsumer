package com.ProducerConsumer.demo.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProducerConsumer.demo.AssemblyLine.Line;
import com.ProducerConsumer.demo.AssemblyLine.Machine;
import com.ProducerConsumer.demo.AssemblyLine.MyQueue;

@CrossOrigin
@RestController
@RequestMapping("/")
public class Draw {

    @PostMapping("/CreatTasks")
    public String creatTasks(@RequestParam int numbetOfTasks) {
        Line l = Line.getInstance();
        for (int i = 0; i < numbetOfTasks; i++) {
            l.addTask();
        }
        return "Tasks added";
    }

    @PostMapping("/AddMachine")
    public String creatMachine(@RequestParam String xy) {
        String[] arr = xy.split("\\$");
        double x = Double.parseDouble(arr[0]);
        double y = Double.parseDouble(arr[1]);
        Line l = Line.getInstance();
        return l.addMachine(x, y);
    }

    @PostMapping("/AddQueue")
    public String creatQueue(@RequestParam String xy) {
        String[] arr = xy.split("\\$");
        double x = Double.parseDouble(arr[0]);
        double y = Double.parseDouble(arr[1]);
        Line l = Line.getInstance();
        return l.addQue(x, y);
    }

    @PostMapping("/MakeArrow")
    public String makeArrow(@RequestParam String id1id2) {
        String[] arr = id1id2.split("\\$");
        Line l = Line.getInstance();
        Machine currentMachine = null;
        MyQueue currentQueue = null;
        int mNum, qNum;
        // machine --> que a machine and next que
        if (arr[0].charAt(0) == 'M') {
            mNum = 0;
            qNum = 1;
        }
        // que --> machine a machine and prev que
        else {
            mNum = 1;
            qNum = 0;
        }
        for (Machine m : l.getMachines()) {
            if (m.getId().equals(arr[mNum])) {
                currentMachine = m;
            }
        }
        // traverse machines, check ids
        for (MyQueue q : l.getQueues()) {
            if (q.getId().equals(arr[qNum])) {
                currentQueue = q;
            }
        }
        if (qNum == 1) {
            currentMachine.setNextvQue(currentQueue);
            currentQueue.addSource(currentMachine);
            return "join machone to que";
        } else {
            currentMachine.setPrevQue(currentQueue);
            currentQueue.addDestination(currentMachine);
            return "join que to machine";
        }
    }

    @PostMapping("/Move")
    public String move(String idxy) {
        String[] arr = idxy.split("\\$");
        String id = arr[0];
        double x = Double.parseDouble(arr[1]);
        double y = Double.parseDouble(arr[2]);
        Line l = null;
        if (id.charAt(0) == 'M') {
            for (Machine m : l.getMachines()) {
                if (m.getId().equals(id)) {
                    m.setX(x);
                    m.setY(y);
                }
            }
        } else {
            for (MyQueue q : l.getQueues()) {
                if (q.getId().equals(id)) {
                    q.setX(x);
                    q.setY(y);
                }
            }
        }
        return "moved " + id;
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam(value = "id") String id) {
        Line l = Line.getInstance();
        int count = 0;
        if (id.charAt(0) == 'M') {
            for (Machine m : l.getMachines()) {
                if (m.getId().equals(id)) {
                    l.getMachines().remove(count);
                }
                count++;
            }
        } else {
            for (MyQueue q : l.getQueues()) {
                if (q.getId().equals(id)) {
                    l.getQueues().remove(count);
                }
                count++;
            }
        }
    }

}
