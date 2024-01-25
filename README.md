# Rote learning

Ứng dụng sẽ lưu trữ đường link và tiêu đề của các bài viết mà người dùng muốn đọc lại. Sau đó, ứng dụng sẽ tự động nhắc người dùng đọc lại các bài viết này sau một khoảng thời gian nhất định.  Từ đó, củng cố kiến thức bằng cách nhắc lại.

## Motivation

Lập trình là lĩnh vực đòi hỏi người học phải đọc nhiều tài liệu. Tuy nhiên, trí nhớ của con người có giới hạn, và kiến thức sẽ phai mờ dần theo thời gian. Theo nghiên cứu, việc nhắc lại kiến thức sau một khoảng thời gian nhất định sẽ giúp chúng ta ghi nhớ lâu hơn. Ứng dụng này hướng tới việc giúp ghi nhớ kiến thức từ các bài viết dài.

![image](https://github.com/thodd2209048/rote-learning-backend/assets/114908027/6956f112-cd43-46a4-bc3d-75db6fe431ac)

## ⚙️ Installation
### System request
* Java JDK 17
* Node.js v18.12.1
* Chrome browser
* PostgreSQL

### Front-end
Tại thư mục chứa front-end. Cài đặt các biến môi trường và chạy ứng dụng: 
```set "REACT_APP_BACK_END_HOST=<back-end-host>" & set "REACT_APP_BACK_END_PORT=<back-end-port>" && serve -s build -l <front-end-port>```

### Back-end
Tại thư mục chứa back-end. Cài đặt các biến môi trường và chạy ứng dụng: 
```java -jar -Dserver.port=<back-end-port> -DFRONT_END_URL=<front-end-url> -DPOSTGRES_HOST=<postgres-host> -DPOSTGRES_PORT=<postgres-port> -DPOSTGRES_PASSWORD=<postgres-password>  -DPOSTGRES_USERNAME=<postgres-username> demo-0.0.1-SNAPSHOT.jar```







