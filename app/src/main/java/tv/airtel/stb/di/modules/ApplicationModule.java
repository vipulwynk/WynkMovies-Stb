/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tv.airtel.stb.di.modules;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import tv.accedo.airtel.wynk.data.executor.JobExecutor;
import tv.accedo.airtel.wynk.data.net.RetrofitClient;
import tv.accedo.airtel.wynk.data.repository.MiddlewareDataRepository;
import tv.accedo.airtel.wynk.data.repository.UserSateDataRepository;
import tv.accedo.airtel.wynk.domain.executor.PostExecutionThread;
import tv.accedo.airtel.wynk.domain.executor.ThreadExecutor;
import tv.accedo.airtel.wynk.domain.manager.UserStateManager;
import tv.accedo.airtel.wynk.domain.repository.DataRepository;
import tv.accedo.airtel.wynk.domain.repository.UserStateRepository;
import tv.airtel.stb.WynkApplication;
import tv.airtel.stb.presentation.UIThread;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {

    private final WynkApplication application;

    public ApplicationModule(WynkApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences("default", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    RetrofitClient provideRetrofitClient(UserStateManager userStateManager) {
        return new RetrofitClient(userStateManager);
    }

    @Provides
    @Singleton
    DataRepository provideMiddlewareDataRepository(MiddlewareDataRepository middlewareDataRepository) {
        return middlewareDataRepository;
    }

    @Provides
    @Singleton
    UserStateRepository provideUserStateRepository(SharedPreferences sharedPreferences) {
        return new UserSateDataRepository(sharedPreferences);
    }

    @Provides
    @Singleton
    UserStateManager provideUserStateManager(UserStateRepository userStateRepository) {
        return new UserStateManager(userStateRepository);
    }
}
