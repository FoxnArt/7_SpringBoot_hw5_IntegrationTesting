package ru.netology._7_springboot_hw1_conditional_application;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
