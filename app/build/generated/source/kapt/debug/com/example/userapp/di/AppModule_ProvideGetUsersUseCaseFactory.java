package com.example.userapp.di;

import com.example.userapp.domain.repository.UserRepository;
import com.example.userapp.domain.usecase.GetUsersUseCase;
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
public final class AppModule_ProvideGetUsersUseCaseFactory implements Factory<GetUsersUseCase> {
  private final Provider<UserRepository> userRepositoryProvider;

  public AppModule_ProvideGetUsersUseCaseFactory(Provider<UserRepository> userRepositoryProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
  }

  @Override
  public GetUsersUseCase get() {
    return provideGetUsersUseCase(userRepositoryProvider.get());
  }

  public static AppModule_ProvideGetUsersUseCaseFactory create(
      Provider<UserRepository> userRepositoryProvider) {
    return new AppModule_ProvideGetUsersUseCaseFactory(userRepositoryProvider);
  }

  public static GetUsersUseCase provideGetUsersUseCase(UserRepository userRepository) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideGetUsersUseCase(userRepository));
  }
}
