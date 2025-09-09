package com.example.userapp.di;

import com.example.userapp.data.remote.UserApi;
import com.example.userapp.domain.repository.UserRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class AppModule_ProvideUserRepositoryFactory implements Factory<UserRepository> {
  private final Provider<UserApi> userApiProvider;

  public AppModule_ProvideUserRepositoryFactory(Provider<UserApi> userApiProvider) {
    this.userApiProvider = userApiProvider;
  }

  @Override
  public UserRepository get() {
    return provideUserRepository(userApiProvider.get());
  }

  public static AppModule_ProvideUserRepositoryFactory create(Provider<UserApi> userApiProvider) {
    return new AppModule_ProvideUserRepositoryFactory(userApiProvider);
  }

  public static UserRepository provideUserRepository(UserApi userApi) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideUserRepository(userApi));
  }
}
