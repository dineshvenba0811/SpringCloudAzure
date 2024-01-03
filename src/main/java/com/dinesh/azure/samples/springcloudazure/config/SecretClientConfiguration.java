package com.dinesh.azure.samples.springcloudazure.config;

import com.azure.core.exception.ClientAuthenticationException;
import com.azure.identity.*;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecretClientConfiguration {
    @Bean
    public SecretClient createSecretClient(){

        AzureCliCredential cliCredential = new AzureCliCredentialBuilder().build();
        return new SecretClientBuilder().vaultUrl("https://organisationkey-dinesh.vault.azure.net/")
                .credential(cliCredential).buildClient();
    }
}
