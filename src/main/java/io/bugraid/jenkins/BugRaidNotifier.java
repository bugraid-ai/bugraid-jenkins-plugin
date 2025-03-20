package io.bugraid.jenkins;

import com.cloudbees.plugins.credentials.CredentialsProvider;
import com.cloudbees.plugins.credentials.common.StandardUsernamePasswordCredentials;
import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.model.Result;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Notifier;
import hudson.tasks.Publisher;
import hudson.util.FormValidation;
import jenkins.model.Jenkins;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class BugRaidNotifier extends Notifier {
    private final String apiKey;
    private final String appKey;
    private final boolean notifyOnStart;
    private final boolean notifyOnSuccess;
    private final boolean notifyOnFailure;

    @DataBoundConstructor
    public BugRaidNotifier(String apiKey, String appKey, boolean notifyOnStart, boolean notifyOnSuccess, boolean notifyOnFailure) {
        this.apiKey = apiKey;
        this.appKey = appKey;
        this.notifyOnStart = notifyOnStart;
        this.notifyOnSuccess = notifyOnSuccess;
        this.notifyOnFailure = notifyOnFailure;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getAppKey() {
        return appKey;
    }

    public boolean isNotifyOnStart() {
        return notifyOnStart;
    }

    public boolean isNotifyOnSuccess() {
        return notifyOnSuccess;
    }

    public boolean isNotifyOnFailure() {
        return notifyOnFailure;
    }

    @Override
    public BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.NONE;
    }

    @Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) {
        // Implementation will be added later
        return true;
    }

    @Extension
    public static final class DescriptorImpl extends BuildStepDescriptor<Publisher> {
        @Override
        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            return true;
        }

        @Override
        public String getDisplayName() {
            return "BugRaid Notification";
        }

        public FormValidation doCheckApiKey(@QueryParameter String value) {
            if (value == null || value.trim().isEmpty()) {
                return FormValidation.error("API Key is required");
            }
            return FormValidation.ok();
        }

        public FormValidation doCheckAppKey(@QueryParameter String value) {
            if (value == null || value.trim().isEmpty()) {
                return FormValidation.error("App Key is required");
            }
            return FormValidation.ok();
        }

        @Override
        public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
            req.bindJSON(this, formData);
            save();
            return super.configure(req, formData);
        }
    }
} 