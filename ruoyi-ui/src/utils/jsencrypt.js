import JSEncrypt from 'jsencrypt/bin/jsencrypt.min'

// 密钥对生成 http://web.chacuo.net/netrsakeypair

// 公钥
const publicKey = 'MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKTcpqOKaBZYA1+/z0cUc2SAuhtIyPOq\n' +
  'sNam3Joy8NNyVPHMutnLhT7cD0RZTq0HWOUfihx452QCfgXD6VJbiDECAwEAAQ=='
// 私钥
const privateKey = 'MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEApNymo4poFlgDX7/P\n' +
  'RxRzZIC6G0jI86qw1qbcmjLw03JU8cy62cuFPtwPRFlOrQdY5R+KHHjnZAJ+BcPp\n' +
  'UluIMQIDAQABAkBcnNe/53CxnJ/ImigG9iYcv3PNAAZjW/AbpYEn3pYLMbhOfoN0\n' +
  'dEGSf8f3gezwlJhDCgctm4ZYsgTXBaeTfkMBAiEA0JcJi6iWpIIEbwcpakzCZ+Yj\n' +
  '2oQWCzX+NsJ5hppCMCUCIQDKVUNy7Szv0k4m61hbvH1l33tWNCAwtHeOg9t5IRWE\n' +
  'HQIgfKNDWOgL25C1BYLKBHKJV3v0wIVchqZkmGPsKbnTAuECIEZOrHpiCgxnwrpp\n' +
  'azGtZNGif6QrxsfF3gmKrhgANA7NAiB6lgB61XQkHxmsHm2sgzLoG+rONHW2dS4R\n' +
  'ollBcXy/Hg=='

// 加密
export function encrypt(txt) {
  const encryptor = new JSEncrypt()
  encryptor.setPublicKey(publicKey) // 设置公钥
  return encryptor.encrypt(txt) // 对数据进行加密
}

// 解密
export function decrypt(txt) {
  const encryptor = new JSEncrypt()
  encryptor.setPrivateKey(privateKey) // 设置私钥
  return encryptor.decrypt(txt) // 对数据进行解密
}

