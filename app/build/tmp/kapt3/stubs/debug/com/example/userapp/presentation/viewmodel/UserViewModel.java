package com.example.userapp.presentation.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/example/userapp/presentation/viewmodel/UserViewModel;", "Landroidx/lifecycle/ViewModel;", "getUsersUseCase", "Lcom/example/userapp/domain/usecase/GetUsersUseCase;", "(Lcom/example/userapp/domain/usecase/GetUsersUseCase;)V", "_errorState", "Landroidx/compose/runtime/MutableState;", "", "_loadingState", "", "_usersState", "", "Lcom/example/userapp/domain/model/User;", "errorState", "Landroidx/compose/runtime/State;", "getErrorState", "()Landroidx/compose/runtime/State;", "loadingState", "getLoadingState", "usersState", "getUsersState", "clearError", "", "loadUsers", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class UserViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.userapp.domain.usecase.GetUsersUseCase getUsersUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.util.List<com.example.userapp.domain.model.User>> _usersState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<java.util.List<com.example.userapp.domain.model.User>> usersState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.lang.Boolean> _loadingState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<java.lang.Boolean> loadingState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.lang.String> _errorState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<java.lang.String> errorState = null;
    
    @javax.inject.Inject()
    public UserViewModel(@org.jetbrains.annotations.NotNull()
    com.example.userapp.domain.usecase.GetUsersUseCase getUsersUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<java.util.List<com.example.userapp.domain.model.User>> getUsersState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<java.lang.Boolean> getLoadingState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<java.lang.String> getErrorState() {
        return null;
    }
    
    public final void loadUsers() {
    }
    
    public final void clearError() {
    }
}