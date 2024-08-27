package com.example;

import java.util.List;

public class Scheduler {

    // First-Come, First-Served (FCFS)
    public void fcfs(List<Process> processes) {
        int currentTime = 0;
        for (Process process : processes) {
            System.out.println("Process " + process.getId() + " is scheduled at time " + currentTime);
            currentTime += process.getBurstTime();
        }
    }

    // Shortest Job First (SJF)
    public void sjf(List<Process> processes) {
        processes.sort((p1, p2) -> Integer.compare(p1.getBurstTime(), p2.getBurstTime()));
        int currentTime = 0;
        for (Process process : processes) {
            System.out.println("Process " + process.getId() + " is scheduled at time " + currentTime);
            currentTime += process.getBurstTime();
        }
    }

    // Round Robin (RR)
    public void roundRobin(List<Process> processes, int quantum) {
        int currentTime = 0;
        while (!processes.isEmpty()) {
            Process process = processes.remove(0);
            if (process.getBurstTime() > quantum) {
                System.out.println("Process " + process.getId() + " is scheduled at time " + currentTime);
                currentTime += quantum;
                processes.add(new Process(process.getId(), process.getBurstTime() - quantum, process.getArrivalTime()));
            } else {
                System.out.println("Process " + process.getId() + " is scheduled at time " + currentTime);
                currentTime += process.getBurstTime();
            }
        }
    }
}
