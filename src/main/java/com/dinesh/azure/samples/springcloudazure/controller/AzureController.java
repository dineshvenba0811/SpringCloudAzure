package com.dinesh.azure.samples.springcloudazure.controller;

import com.azure.security.keyvault.secrets.SecretClient;
import com.dinesh.azure.samples.springcloudazure.config.SecretClientConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/azure")
public class AzureController {

    public AzureController(SecretClient secretClient) {
        this.secretClient = secretClient;
    }

    private SecretClient secretClient;
    @GetMapping("/keyvault")
    public String getAzureKeyValutSecret(){
     System.out.println("key -"+secretClient.getSecret("mysql-database-keys").getValue());
     return secretClient.getSecret("mysql-database-keys").getValue();
    }
}
