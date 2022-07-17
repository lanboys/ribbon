package com.netflix.ribbon.examples.restclient;

import com.netflix.client.ClientFactory;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.io.IOException;

/**
 * Created by oopcoder at 2022/7/17 10:55 .
 */

public class QuickStart {

  public static void main(String[] args) throws IOException {
    // 加载配置文件
    ConfigurationManager.loadCascadedPropertiesFromResources("sample-client");

    ILoadBalancer loadBalancer = ClientFactory.getNamedLoadBalancer("sample-client");
    for (int i = 0; i < 10; i++) {
      Server server = loadBalancer.chooseServer(null);
      System.out.println("request: " + server.getHostPort());
    }
  }
}
