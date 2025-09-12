package com.example.userapp.domainTest;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\bH\u0007J\b\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/userapp/domainTest/GetUsersUseCaseTest;", "", "()V", "getUsersUseCase", "Lcom/example/userapp/domain/usecase/GetUsersUseCase;", "mockUserRepository", "Lcom/example/userapp/domain/repository/UserRepository;", "InvokeShouldReturnEmptyListWhenRepositoryReturnsEmptyList", "", "InvokeShouldReturnFailureWhenRepositoryFails", "InvokeShouldReturnSuccessWithUsersListWhenRepositorySucceeds", "invoke should delegate call to repository exactly once", "invoke should handle different result types from repository", "invoke should not modify repository response", "setup", "app_debugUnitTest"})
public final class GetUsersUseCaseTest {
    @org.mockito.Mock()
    private com.example.userapp.domain.repository.UserRepository mockUserRepository;
    private com.example.userapp.domain.usecase.GetUsersUseCase getUsersUseCase;
    
    public GetUsersUseCaseTest() {
        super();
    }
    
    @org.junit.Before()
    public final void setup() {
    }
    
    @org.junit.Test()
    public final void InvokeShouldReturnSuccessWithUsersListWhenRepositorySucceeds() {
    }
    
    @org.junit.Test()
    public final void InvokeShouldReturnFailureWhenRepositoryFails() {
    }
    
    @org.junit.Test()
    public final void InvokeShouldReturnEmptyListWhenRepositoryReturnsEmptyList() {
    }
}