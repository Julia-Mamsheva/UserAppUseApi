## Описание проекта
Проект UserAppUseApi представляет собой Android-приложение для работы с пользовательскими данными, взаимодействующее с внешним API. Приложение использует такие подходы к разработке, как Clean Architecture и MVVM паттерна

## Clean Architecture
Проект построен по принципам Clean Architecture (Чистой Архитектуры) Роберта Мартина, которая обеспечивает:

* Независимость от фреймворков - архитектура не зависит от внешних библиотек
* Тестируемость - бизнес-правила могут быть протестированы без UI, БД и внешних зависимостей
* Независимость от UI - UI может легко изменяться без изменения бизнес-логики
* Независимость от БД - бизнес-правила не зависят от базы данных
* Независимость от внешних агентов - бизнес-правила ничего не знают о внешних интерфейсах

Слои Clean Architecture:
1. Domain Layer (Внутренний слой)
   * Содержит бизнес-логику и enterprise rules
   * Включает Entities, Use Cases, Repository Interfaces
   * Не зависит от внешних слоев

2. Data Layer
   * Реализация репозиториев из Domain слоя
   * Источники данных (API, база данных)
   * Зависит от Domain слоя

3. Presentation Layer (Внешний слой)
   * UI компоненты (Activity, Fragment)
   * ViewModel, State management
   * Зависит от Domain слоя

## MVVM Pattern
В рамках Presentation Layer используется MVVM (Model-View-ViewModel):
* View - Android компоненты (Activity, Fragment)
* ViewModel - хранит и управляет UI-related data
* Model - бизнес-логика и данные из Domain layer

# Ключевые компоненты
1. Data Layer
   * ApiService - интерфейс Retrofit для работы с API
   * UserRepository - централизованный доступ к данным пользователей
   * Data Models - классы данных (User, UserResponse и др.)

2. Domain Layer
   * Use Cases - бизнес-логика приложения
   * Repository Interfaces - абстракции для доступа к данным

3. Presentation Layer
   * MainActivity - основная активность приложения
   * UserViewModel - ViewModel для управления UI логикой
   * Adapters - адаптеры для RecyclerView и других View компонентов

4. DI Layer
   * AppModule - модули для внедрения зависимостей
   * ViewModelFactory - фабрика для создания ViewModel

## Функциональность
* Получение списка пользователей из API
* Отображение пользовательских данных в RecyclerView
* Обработка состояний загрузки и ошибок
* Поддержка пагинации (если реализовано)
* Кэширование данных (опционально)

## Технологический стек
* Kotlin - основной язык разработки
* Retrofit - для сетевых запросов
* Coroutines/Flow - для асинхронных операций
* ViewModel/LiveData - для управления UI состоянием
* Koin/Hilt - для dependency injection
