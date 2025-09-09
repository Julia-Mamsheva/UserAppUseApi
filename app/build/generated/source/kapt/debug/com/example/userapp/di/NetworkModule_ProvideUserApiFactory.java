package com.example.userapp.di;

import com.example.userapp.data.remote.UserApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class NetworkModule_ProvideUserApiFactory implements Factory<UserApi> {
  @Override
  public UserApi get() {
    return provideUserApi();
  }

  public static NetworkModule_ProvideUserApiFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static UserApi provideUserApi() {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideUserApi());
  }

  private static final class InstanceHolder {
    private static final NetworkModule_ProvideUserApiFactory INSTANCE = new NetworkModule_ProvideUserApiFactory();
  }
}
