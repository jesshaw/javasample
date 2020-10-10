package com.lexiangmiao.sample.concurrent.atomicreference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

@AllArgsConstructor
@Getter
@ToString
public class UserDemo {
    String userName;
    int age;

    public static void main(String[] args) {
        UserDemo z3 = new UserDemo("z3",22);
        UserDemo li4 = new UserDemo("li4",27);

        AtomicReference<UserDemo> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);

        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"+atomicReference.get().toString());
    }
}
