/*import java.util.*;

public class bestrelayteam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<String> runnerNames = new ArrayList<>();
        ArrayList<Double> firstLegTimings = new ArrayList<>();
        ArrayList<Double> secondLegTimings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            String[] data = temp.split(" ");
            runnerNames.add(data[0]);
            firstLegTimings.add(Double.parseDouble(data[1]));
            secondLegTimings.add(Double.parseDouble(data[2]));
        }

        double bestTotalTime = Double.MAX_VALUE;
        String[] bestTeam = new String[4];

        ArrayList<Double> sortedFirstLegTimings = new ArrayList<>(firstLegTimings);
        Collections.sort(sortedFirstLegTimings);

        for (int i = 0; i < 4; i++) {
            double totalTime = sortedFirstLegTimings.get(i);
            String firstRunner = runnerNames.get(firstLegTimings.indexOf(sortedFirstLegTimings.get(i)));
            
            ArrayList<Double> remainingSecondLegTimings = new ArrayList<>(secondLegTimings);
            remainingSecondLegTimings.remove(firstLegTimings.indexOf(sortedFirstLegTimings.get(i)));
            Collections.sort(remainingSecondLegTimings);
            System.out.println(remainingSecondLegTimings);
            System.out.println();

            for (int j = 0; j < 3; j++) {
                totalTime += remainingSecondLegTimings.get(j);
            }

            if (totalTime < bestTotalTime) {
                bestTotalTime = totalTime;
                bestTeam[0] = firstRunner;
                bestTeam[1] = runnerNames.get(secondLegTimings.indexOf(remainingSecondLegTimings.get(0)));
                bestTeam[2] = runnerNames.get(secondLegTimings.indexOf(remainingSecondLegTimings.get(1)));
                bestTeam[3] = runnerNames.get(secondLegTimings.indexOf(remainingSecondLegTimings.get(2)));
            }
        }

        System.out.println(bestTotalTime);
        for (String runner : bestTeam) {
            System.out.println(runner);
        }

        sc.close();
    }
}*/

import java.util.*;

class Runner {
    String name;
    double firstLegTiming;
    double secondLegTiming;

    public Runner(String name, double firstLegTiming, double secondLegTiming) {
        this.name = name;
        this.firstLegTiming = firstLegTiming;
        this.secondLegTiming = secondLegTiming;
    }
}

public class bestrelayteam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<Runner> runners = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            String[] data = temp.split(" ");
            runners.add(new Runner(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2])));
        }

        double bestTotalTime = Double.MAX_VALUE;
        String[] bestTeam = new String[4];

        ArrayList<Runner> sortedFirstLegRunners = new ArrayList<>(runners);
        sortedFirstLegRunners.sort(Comparator.comparingDouble(runner -> runner.firstLegTiming));

        for (int i = 0; i < 4; i++) {
            Runner firstRunner = sortedFirstLegRunners.get(i);

            ArrayList<Runner> remainingSecondLegRunners = new ArrayList<>(runners);
            remainingSecondLegRunners.remove(firstRunner);

            remainingSecondLegRunners.sort(Comparator.comparingDouble(runner -> runner.secondLegTiming));
            Runner secondRunner1 = remainingSecondLegRunners.get(0);
            Runner secondRunner2 = remainingSecondLegRunners.get(1);
            Runner secondRunner3 = remainingSecondLegRunners.get(2);

            double totalTime = firstRunner.firstLegTiming +
                secondRunner1.secondLegTiming + secondRunner2.secondLegTiming + secondRunner3.secondLegTiming;

            if (totalTime < bestTotalTime) {
                bestTotalTime = totalTime;
                bestTeam[0] = firstRunner.name;
                bestTeam[1] = secondRunner1.name;
                bestTeam[2] = secondRunner2.name;
                bestTeam[3] = secondRunner3.name;
            }
        }

        System.out.println(bestTotalTime);
        for (String runner : bestTeam) {
            System.out.println(runner);
        }

        sc.close();
    }
}
