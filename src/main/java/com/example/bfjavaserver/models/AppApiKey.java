package com.example.bfjavaserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "apps_api_keys")
public class AppApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column
    public String key;

    @Column(name = "finish_time")
    public long finishTime;

    @Column(name="app_id")
    public int appId;

    @Column(name = "device_id")
    public String deviceId;
}