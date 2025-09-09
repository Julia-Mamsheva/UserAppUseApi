package com.example.userapp.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u00a7@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/example/userapp/data/remote/UserApi;", "", "getUserById", "Lcom/example/userapp/data/dto/UserDto;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUsers", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface UserApi {
    
    @retrofit2.http.GET(value = "users")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUsers(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.userapp.data.dto.UserDto>> $completion);
    
    @retrofit2.http.GET(value = "users/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserById(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.userapp.data.dto.UserDto> $completion);
}