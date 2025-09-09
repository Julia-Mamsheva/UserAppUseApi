package com.example.userapp.presentation.viewmodel;

import com.example.userapp.domain.usecase.GetUsersUseCase;
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
public final class UserViewModel_Factory implements Factory<UserViewModel> {
  private final Provider<GetUsersUseCase> getUsersUseCaseProvider;

  public UserViewModel_Factory(Provider<GetUsersUseCase> getUsersUseCaseProvider) {
    this.getUsersUseCaseProvider = getUsersUseCaseProvider;
  }

  @Override
  public UserViewModel get() {
    return newInstance(getUsersUseCaseProvider.get());
  }

  public static UserViewModel_Factory create(Provider<GetUsersUseCase> getUsersUseCaseProvider) {
    return new UserViewModel_Factory(getUsersUseCaseProvider);
  }

  public static UserViewModel newInstance(GetUsersUseCase getUsersUseCase) {
    return new UserViewModel(getUsersUseCase);
  }
}
