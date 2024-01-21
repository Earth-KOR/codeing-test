package com.coding.test.basic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.beans.Transient;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class TwoPointerCreateService {

    @Test
    public void twoPointer() {
        int target = 14;
        int[] list = new int[7];
        list[0] = 4;
        list[1] = 1;
        list[2] = 9;
        list[3] = 7;
        list[4] = 5;
        list[5] = 3;
        list[6] = 16;

        List<Integer> collect = Arrays.stream(list).boxed().collect(Collectors.toList());

        Collections.sort(collect);

        int head = 0;
        int tail = collect.size() - 1;

        while (head < tail) {
            int i = collect.get(head) + collect.get(tail);
            if(list[head] + list[tail] > target) {
                tail = tail -1;
                continue;
            }
            if(collect.get(head) + collect.get(tail) < target) {
                head = head +1;
                continue;
            }
            if (collect.get(head) + collect.get(tail) == target) {
                System.out.println("true");
                break;
            }
        }

        System.out.println("false");
    }
}
