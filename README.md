# ESAP_VM
Лабораторная 1: Application with common JavaEE architecture
Выполнили: Губаев Муслим и Коршиков Владислав Игоревич 6133-010402D

Мы создали простое веб-приложение для фирмы, занимающейся прокатом велосипедов
В его основе лежат три таблицы: bikes(велосипеды), drives(запланированные проездки) и users(пользователи).
![image](https://sun9-76.userapi.com/impg/P6r2zG_X0HOYj-tDeeoeo8JEvGNUY_OODTHKVQ/SOA8QNWrQok.jpg?size=1015x258&quality=96&sign=dd4c9b9c5241fdf71f89bcea4b2cb951&type=album)
В качестве базы данных используется Postgresql, для хостинга сервера приложения используется glassfish 6.2.3 c jakarta, само приложение написано на Java 17.0.1 в среде разработки IntelliJ IDEA 2021.2.3 

В таблице bikes указывается id велосипеда, цена за час поездки.
Страница show bikes поддерживает следующую функциональность:  переход на страницу для обновления записи, удаление записи, переход на страницу для создания новой записи.
![Страница ShowBikes.jsp](https://sun9-43.userapi.com/impg/ssmJ3Kzn_rr5YqZjkWc6SgvGBq4MmT2iu4sRog/dgyQMEf5rfc.jpg?size=1701x573&quality=96&sign=6d8bd0f503abb8e029d1d8ac64c57e46&type=album)
![image](https://sun9-15.userapi.com/impg/WNGLLfKeCPVf4U8DTXzTaARIosz_uUSDoCIYuQ/U7GpYKpZxR8.jpg?size=1553x362&quality=96&sign=11988d5360597b45b968c72c04675354&type=album)

В таблице drives указывается: id поездки, продолжительность(в часах), стоимость(рассчитывается автоматически: продолжительность x цена за час (bikes)), id велосипеда(bikes), название велосипеда(bikes), id пользователя(users) и имя пользователя(users)
Страница show drives поддерживает следующую функциональность: удаление записи, переход на страницу для создания новой записи. Возможность обновления записи отключена.
![image](https://user-images.githubusercontent.com/78798481/148638859-48f5088c-eda3-4fea-8367-cccb5d7ea0fe.png)
![image](https://user-images.githubusercontent.com/78798481/148639102-e761d7a5-0e2d-41a4-b310-b0f6c6be88f5.png))




В таблице users указывается: id пользователя, имя пользователя, доступные денежные средства
Страница show users поддерживает следующую функциональность: обновление записи, удаление записи, создание новой записи.
Таблица users и bikes поддерживают каскадное удаление, при удалении записи из них, связанные записи из drives также удаляются.
![image](https://user-images.githubusercontent.com/78798481/148639127-544631fe-a56b-4b13-82f5-6e39adc929ce.png)
![image](https://sun9-28.userapi.com/impg/RsuoitDwg37N57kUeDUzNLOXORHhqRWvn0L9fw/TqjPYkuh048.jpg?size=1853x381&quality=96&sign=bd0e9ced372a2ca9bc3b6c87023d2541&type=album)
