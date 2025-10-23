# 📸 HƯỚNG DẪN API UPLOAD HÌNH ẢNH SẢN PHẨM

## 🔧 **CẤU HÌNH**

### **Cloudinary Configuration**

```properties
cloudinaryName = "di2a8fvuv"
cloudinaryKey = "952239256585686"
cloudinarySecretKey = "yR2fnx-fYqQDDzGX0Ex_vfiN47Q"
```

### **⚠️ File Upload Limits (QUAN TRỌNG)**

```properties
# Maximum file size per file
spring.servlet.multipart.max-file-size=2MB

# Maximum request size (for multiple files)
spring.servlet.multipart.max-request-size=10MB

# Enable multipart uploads
spring.servlet.multipart.enabled=true
```

💡 **Nếu bạn gặp lỗi `"Maximum upload size exceeded"` với code 1001:**

- Spring Boot đang chặn file lớn hơn 2MB
- Đã cấu hình lại trong `application.properties`
- **Cần RESTART server** để cấu hình có hiệu lực!

---

## 📋 **API ENDPOINT**

### **1. Upload Hình Ảnh Sản Phẩm**

**Endpoint:** `POST /api/v1/images/upload/{productId}`

**Authentication:** Required (Role: SHOP)

**Content-Type:** `multipart/form-data`

**Parameters:**

- `{productId}` (path) - ID sản phẩm cần upload ảnh
- `files` (form-data) - Mảng các file ảnh (có thể upload nhiều ảnh cùng lúc)
- `positions` (form-data, optional) - Mảng vị trí hiển thị tương ứng với từng ảnh

---

## 🧪 **TEST VỚI POSTMAN**

### **Bước 1: Setup Request**

1. **Method:** POST
2. **URL:** `http://localhost:8080/api/v1/images/upload/1`

   - Thay `1` bằng ID sản phẩm thực tế

3. **Headers:**
   ```
   Authorization: Bearer YOUR_JWT_TOKEN
   ```

### **Bước 2: Body - form-data**

**Option A: Upload không chỉ định position (tự động)**

```
KEY         | TYPE  | VALUE
------------|-------|------------------
files       | File  | image1.jpg
files       | File  | image2.png
files       | File  | image3.webp
```

**Option B: Upload với position cụ thể**

```
KEY         | TYPE  | VALUE
------------|-------|------------------
files       | File  | image1.jpg
files       | File  | image2.png
positions   | Text  | 0
positions   | Text  | 1
```

⚠️ **Lưu ý:**

- Số lượng `positions` phải bằng số lượng `files` (nếu có)
- Position bắt đầu từ 0
- Nếu không gửi positions, hệ thống tự động sắp xếp

---

## 📝 **VALIDATION RULES**

### **File Validation:**

| Quy tắc                | Giá trị                        | Error Code                   |
| ---------------------- | ------------------------------ | ---------------------------- |
| **Kích thước tối đa**  | 2MB                            | `MAX_FILE_SIZE` (1705)       |
| **Định dạng cho phép** | jpg, jpeg, png, gif, bmp, webp | `FORMAT_FILE_VALID` (1706)   |
| **File rỗng**          | Không cho phép                 | `FAIL_TO_UPLOAD_FILE` (1707) |

### **Product Validation:**

- Product phải tồn tại
- User phải có role `SHOP`

---

## ✅ **RESPONSE MẪU**

### **Success Response (200 OK):**

```json
{
  "success": true,
  "message": "Upload images successfully",
  "result": [
    {
      "id": 123,
      "productId": 1,
      "imageUrl": "https://res.cloudinary.com/di2a8fvuv/image/upload/v1234567890/petshop/product/1_1234567890_0.jpg",
      "position": 0,
      "isPrimary": 0,
      "isDeleted": "0"
    },
    {
      "id": 124,
      "productId": 1,
      "imageUrl": "https://res.cloudinary.com/di2a8fvuv/image/upload/v1234567890/petshop/product/1_1234567891_1.png",
      "position": 1,
      "isPrimary": 0,
      "isDeleted": "0"
    }
  ]
}
```

### **Error Responses:**

**1. File quá lớn (413 Payload Too Large):**

```json
{
  "success": false,
  "code": 1705,
  "message": "Kích thước file tối đa là 2MB"
}
```

**2. Định dạng file không hợp lệ (400 Bad Request):**

```json
{
  "success": false,
  "code": 1706,
  "message": "Chỉ chấp nhận định dạng jpg|jpeg|png|gif|bmp|webp"
}
```

**3. Upload thất bại (500 Internal Server Error):**

```json
{
  "success": false,
  "code": 1707,
  "message": "Tải lên file thất bại"
}
```

**4. Unauthorized (401):**

```json
{
  "success": false,
  "code": 1100,
  "message": "Chưa xác thực"
}
```

**5. Forbidden (403):**

```json
{
  "success": false,
  "code": 1101,
  "message": "Bạn không có quyền truy cập"
}
```

---

## 🔍 **DEBUG CHECKLIST**

Nếu upload bị lỗi, kiểm tra các điểm sau:

### **1. Cloudinary Configuration**

```bash
# Kiểm tra console log khi start application
✅ Cloudinary bean should be created successfully
```

### **2. File Validation**

- [ ] File size < 2MB
- [ ] File type là image (jpg, jpeg, png, gif, bmp, webp)
- [ ] File không rỗng
- [ ] Content-Type header đúng

### **3. Authentication**

- [ ] JWT token hợp lệ
- [ ] User có role SHOP
- [ ] Token chưa hết hạn

### **4. Product Validation**

- [ ] ProductId tồn tại trong database
- [ ] Product chưa bị xóa (isDeleted = "0")

### **5. Network**

- [ ] Internet connection hoạt động
- [ ] Có thể truy cập Cloudinary API
- [ ] Firewall không chặn

---

## 🛠️ **TROUBLESHOOTING**

### **🚨 Lỗi: "Maximum upload size exceeded" (Code: 1001)**

**Response nhận được:**

```json
{
  "code": 1001,
  "success": true,
  "message": "Maximum upload size exceeded"
}
```

**Nguyên nhân:**

- Spring Boot mặc định giới hạn upload file = 1MB
- File của bạn lớn hơn giới hạn này

**✅ Giải pháp:**

1. Đã thêm cấu hình vào `application.properties`:

   ```properties
   spring.servlet.multipart.max-file-size=2MB
   spring.servlet.multipart.max-request-size=10MB
   ```

2. **RESTART lại server** để cấu hình có hiệu lực:

   ```bash
   # Stop server (Ctrl+C)
   # Start lại: mvnw spring-boot:run (hoặc chạy từ IDE)
   ```

3. Test lại với file < 2MB

---

### **Lỗi: "Tải lên file thất bại"**

**Nguyên nhân có thể:**

1. Cloudinary credentials sai
2. Network issue
3. File bị corrupt
4. Cloudinary quota đã hết

**Giải pháp:**

```bash
# 1. Kiểm tra console log để xem lỗi chi tiết
# 2. Verify Cloudinary credentials
# 3. Test upload file khác
# 4. Kiểm tra Cloudinary dashboard quota
```

### **Lỗi: "Định dạng file không hợp lệ"**

**Giải pháp:**

- Chỉ upload file ảnh: jpg, jpeg, png, gif, bmp, webp
- Kiểm tra MIME type của file
- Đổi tên file nếu có ký tự đặc biệt

### **Lỗi: "Kích thước file tối đa là 2MB"**

**Giải pháp:**

- Nén ảnh trước khi upload
- Sử dụng tool như TinyPNG, ImageOptim
- Giảm resolution nếu cần

---

## 📊 **FILE NAMING CONVENTION**

Hệ thống tự động đặt tên file theo format:

```
{productId}_{timestamp}_{index}.{extension}

Ví dụ:
- 1_1698123456789_0.jpg
- 1_1698123456789_1.png
```

**Lưu trữ trên Cloudinary:**

```
Folder: petshop/product/
Public ID: petshop/product/1_1698123456789_0.jpg
URL: https://res.cloudinary.com/di2a8fvuv/image/upload/v.../petshop/product/1_1698123456789_0.jpg
```

---

## 🎯 **BEST PRACTICES**

1. **Upload theo batch:**

   - Upload nhiều ảnh cùng lúc (tối đa 10 ảnh/request)
   - Giảm số lượng API calls

2. **Optimize images trước khi upload:**

   - Resize về kích thước phù hợp
   - Compress để giảm dung lượng
   - Chọn format phù hợp (WebP tốt nhất)

3. **Handle errors properly:**

   - Hiển thị message lỗi rõ ràng cho user
   - Retry upload nếu network issue
   - Log errors để debug

4. **Position management:**
   - Gửi positions nếu muốn sắp xếp tùy chỉnh
   - Bỏ qua positions để tự động tăng dần

---

## 📞 **SUPPORT**

Nếu vẫn gặp vấn đề, kiểm tra:

1. Console log của backend
2. Network tab trong Browser DevTools
3. Cloudinary dashboard: https://cloudinary.com/console

---

---

## 🔄 **CHANGELOG**

### **Version 1.1** - October 24, 2025

- ✅ Fixed: Thêm cấu hình `max-file-size` và `max-request-size` trong `application.properties`
- ✅ Fixed: Giải quyết lỗi "Maximum upload size exceeded" (Code 1001)
- 📝 Updated: Thêm section troubleshooting cho lỗi upload size

### **Version 1.0** - October 23, 2025

- 🎉 Initial release: API documentation
- ✅ Cloudinary integration guide
- ✅ Postman testing guide

---

**Author:** Pet Shop Team - Nhóm 20
