package com.example.userapp.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\nJ\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\u0006H\u0096@\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/userapp/data/repository/UserRepositoryImpl;", "Lcom/example/userapp/domain/repository/UserRepository;", "userApi", "Lcom/example/userapp/data/remote/UserApi;", "(Lcom/example/userapp/data/remote/UserApi;)V", "getUserById", "Lcom/example/userapp/domain/model/Result;", "Lcom/example/userapp/domain/model/User;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUsers", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class UserRepositoryImpl implements com.example.userapp.domain.repository.UserRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.userapp.data.remote.UserApi userApi = null;
    
    @javax.inject.Inject()
    public UserRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.userapp.data.remote.UserApi userApi) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getUsers(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.userapp.domain.model.Result<? extends java.util.List<com.example.userapp.domain.model.User>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getUserById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.userapp.domain.model.Result<com.example.userapp.domain.model.User>> $completion) {
        return null;
    }
}