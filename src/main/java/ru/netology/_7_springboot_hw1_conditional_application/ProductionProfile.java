package ru.netology._7_springboot_hw1_conditional_application;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
