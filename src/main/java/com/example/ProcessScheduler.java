package com.example;

import java.util.ArrayList;
import java.util.List;

public class ProcessScheduler {

    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process(1, 10, 5));
        processes.add(new Process(2, 1, 2));
        processes.add(new Process(3, 2, 1));

        Scheduler scheduler = new Scheduler();

        System.out.println("First-Come, First-Served (FCFS):");
        scheduler.fcfs(processes);
        System.out.println();

        System.out.println("Shortest Job First (SJF):");
        scheduler.sjf(processes);
        System.out.println();

        System.out.println("Round Robin (RR):");
        scheduler.roundRobin(processes, 2);
        System.out.println();
    }
}
