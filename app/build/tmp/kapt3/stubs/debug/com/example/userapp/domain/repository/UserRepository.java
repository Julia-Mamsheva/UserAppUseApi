package com.example.userapp.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\u0003H\u00a6@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/example/userapp/domain/repository/UserRepository;", "", "getUserById", "Lcom/example/userapp/domain/model/Result;", "Lcom/example/userapp/domain/model/User;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUsers", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface UserRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUsers(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.userapp.domain.model.Result<? extends java.util.List<com.example.userapp.domain.model.User>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.userapp.domain.model.Result<com.example.userapp.domain.model.User>> $completion);
}