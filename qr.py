import qrcode
import hashlib
# function 
result = hashlib.md5(b"DacNhanTamVoPhuocNguyen").hexdigest()
print(result)

qr = qrcode.QRCode(version=1,box_size=15,border=5)
data = result

qr.add_data(data)
qr.make(fit=True)
img = qr.make_image(fill='black',back_color='white')
img.save('Helloae.png')