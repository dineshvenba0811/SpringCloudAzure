package com.dinesh.azure.samples.springcloudazure.controller;

import com.azure.core.exception.ClientAuthenticationException;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
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

        try {
            String secret = secretClient.getSecret("mysqldatabase-keys").getValue();
        } catch (ClientAuthenticationException e) {
            //Handle Exception
            e.printStackTrace();
        }


     return secretClient.getSecret("mysqldatabase-keys").getValue();
    }
}
