package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> sourceArray = new ArrayList<>();
        ArrayList<ArrayList<Integer>> groupsNumbers = new ArrayList<>();

        for (int i = 0; i < 50; i++) sourceArray.add(i + 1);

        for (int i = 0; sourceArray.size() != 0; i++) {

            ArrayList<Integer> currentArray = new ArrayList<>();
            groupsNumbers.add(currentArray);

            for (int j = 0; j < sourceArray.size(); ) {

                boolean remove = false;

                if (groupsNumbers.get(i).size() == 0) {
                    currentArray.add(sourceArray.get(j));
                    sourceArray.remove(j);
                    remove = true;
                } else {
                    boolean propertyOfSeparability = true;
                    for (int g = 0; g < groupsNumbers.get(i).size(); g++) {
                        if (groupsNumbers.get(i).size() > 0 && sourceArray.get(j) % groupsNumbers.get(i).get(g) == 0) {
                            propertyOfSeparability = false;
                            break;
                        }
                    }

                    if (propertyOfSeparability) {
                        currentArray.add(sourceArray.get(j));
                        sourceArray.remove(j);
                        remove = true;
                    }

                }

                if (!remove) j++;

            }
        }

        groupsNumbers.forEach(integers -> System.out.println("Группа: " + integers.toString()));

    }
}
