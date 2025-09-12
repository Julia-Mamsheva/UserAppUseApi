package com.example.userapp;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\bH\u0007R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/userapp/UserRepositoryImplTest;", "", "()V", "mockUserApi", "Lcom/example/userapp/data/remote/UserApi;", "userRepository", "Lcom/example/userapp/data/repository/UserRepositoryImpl;", "GetUsersShouldReturnSuccessWithUsersWhenAPICallSucceeds", "", "getUserByIdShouldReturnFailureWhenUserNotFound", "getUserByIdShouldReturnSuccessWithUserWhenFound", "getUsersShouldReturnFailureWhenAPICallThrowsException", "setup", "app_debugUnitTest"})
public final class UserRepositoryImplTest {
    @org.mockito.Mock()
    private com.example.userapp.data.remote.UserApi mockUserApi;
    private com.example.userapp.data.repository.UserRepositoryImpl userRepository;
    
    public UserRepositoryImplTest() {
        super();
    }
    
    @org.junit.Before()
    public final void setup() {
    }
    
    @org.junit.Test()
    public final void GetUsersShouldReturnSuccessWithUsersWhenAPICallSucceeds() {
    }
    
    @org.junit.Test()
    public final void getUsersShouldReturnFailureWhenAPICallThrowsException() {
    }
    
    @org.junit.Test()
    public final void getUserByIdShouldReturnSuccessWithUserWhenFound() {
    }
    
    @org.junit.Test()
    public final void getUserByIdShouldReturnFailureWhenUserNotFound() {
    }
}