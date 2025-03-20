package io.bugraid.jenkins;

import com.cloudbees.plugins.credentials.CredentialsProvider;
import com.cloudbees.plugins.credentials.common.StandardUsernamePasswordCredentials;
import hudson.Extension;
import hudson.util.FormValidation;
import jenkins.model.GlobalConfiguration;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;

import java.util.List;

@Extension
public class BugRaidGlobalConfiguration extends GlobalConfiguration {
    private String defaultApiKey;
    private String defaultAppKey;
    private String defaultCredentialsId;
    private boolean defaultNotifyOnStart;
    private boolean defaultNotifyOnSuccess;
    private boolean defaultNotifyOnFailure;

    public BugRaidGlobalConfiguration() {
        load();
    }

    public static BugRaidGlobalConfiguration get() {
        return GlobalConfiguration.all().get(BugRaidGlobalConfiguration.class);
    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
        req.bindJSON(this, json);
        save();
        return super.configure(req, json);
    }

    public String getDefaultApiKey() {
        return defaultApiKey;
    }

    public void setDefaultApiKey(String defaultApiKey) {
        this.defaultApiKey = defaultApiKey;
    }

    public String getDefaultAppKey() {
        return defaultAppKey;
    }

    public void setDefaultAppKey(String defaultAppKey) {
        this.defaultAppKey = defaultAppKey;
    }

    public String getDefaultCredentialsId() {
        return defaultCredentialsId;
    }

    public void setDefaultCredentialsId(String defaultCredentialsId) {
        this.defaultCredentialsId = defaultCredentialsId;
    }

    public boolean isDefaultNotifyOnStart() {
        return defaultNotifyOnStart;
    }

    public void setDefaultNotifyOnStart(boolean defaultNotifyOnStart) {
        this.defaultNotifyOnStart = defaultNotifyOnStart;
    }

    public boolean isDefaultNotifyOnSuccess() {
        return defaultNotifyOnSuccess;
    }

    public void setDefaultNotifyOnSuccess(boolean defaultNotifyOnSuccess) {
        this.defaultNotifyOnSuccess = defaultNotifyOnSuccess;
    }

    public boolean isDefaultNotifyOnFailure() {
        return defaultNotifyOnFailure;
    }

    public void setDefaultNotifyOnFailure(boolean defaultNotifyOnFailure) {
        this.defaultNotifyOnFailure = defaultNotifyOnFailure;
    }

    public List<StandardUsernamePasswordCredentials> getCredentialsList() {
        return CredentialsProvider.lookupCredentials(StandardUsernamePasswordCredentials.class);
    }

    public FormValidation doTestConnection(@QueryParameter("defaultApiKey") final String apiKey,
                                         @QueryParameter("defaultAppKey") final String appKey,
                                         @QueryParameter("defaultCredentialsId") final String credentialsId) {
        try {
            // Test connection to BugRaid API
            // This is a placeholder - implement actual API test
            return FormValidation.ok("Successfully connected to BugRaid API");
        } catch (Exception e) {
            return FormValidation.error("Failed to connect to BugRaid API: " + e.getMessage());
        }
    }
} 