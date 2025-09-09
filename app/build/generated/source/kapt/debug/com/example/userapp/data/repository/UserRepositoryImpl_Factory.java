package com.example.userapp.data.repository;

import com.example.userapp.data.remote.UserApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class UserRepositoryImpl_Factory implements Factory<UserRepositoryImpl> {
  private final Provider<UserApi> userApiProvider;

  public UserRepositoryImpl_Factory(Provider<UserApi> userApiProvider) {
    this.userApiProvider = userApiProvider;
  }

  @Override
  public UserRepositoryImpl get() {
    return newInstance(userApiProvider.get());
  }

  public static UserRepositoryImpl_Factory create(Provider<UserApi> userApiProvider) {
    return new UserRepositoryImpl_Factory(userApiProvider);
  }

  public static UserRepositoryImpl newInstance(UserApi userApi) {
    return new UserRepositoryImpl(userApi);
  }
}
