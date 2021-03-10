package com.ruoyi.framework.license;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author zcy 2019年5月31日
 */
@Component
public final class License extends MultiTypeValMap {

  private static final Logger log = LoggerFactory.getLogger(License.class);

  /** */
  private static final long serialVersionUID = -5520061786135596348L;

  private static License INSTANCE = new License();

  private LicenseDataLoader loader;

  /**
   * 服务器id
   */
  private List<String> uuids;

  private License() {
  }

  public static License get() {
    return INSTANCE;
  }
  
  public static License create() {
      return new License();
    }

  public void setLicenseDataLoader(LicenseDataLoader loader) {
    this.loader = loader;
  }

  public void put(String key, Object val) {
    throw new UnsupportedOperationException();
  }

  public void putAll(Map<String, Object> vals) {
    throw new UnsupportedOperationException();
  }

  /**
   *
   */
  public void init() {
    try {
      if (this.uuids != null) {
        this.uuids.clear();
      }
      getVals().clear();
      byte[] licenseData = this.loader.load();
      byte[] decryptData = decrypt(licenseData);
      if (decryptData == null || decryptData.length == 0) {
        throw new LicenseException("init License data fail, not found data");
      }
      Properties properties = new Properties();
      properties.load(new ByteArrayInputStream(decryptData));
      properties.forEach((k, v) -> {
        super.put(k.toString(), v);
      });
      try {
        this.uuids = new ArrayList<String>();
        String systemuid = BlackBox.decodesystemid(licenseData);
        if (systemuid != null) {
          //支持license逗号和换行符切割
          for (String uid : systemuid.split("[\n,]")) {
            this.uuids.add(uid);
          }
        }
      } catch (Throwable e) {
        log.error("decode systemid fail", e);
      }
    } catch (LicenseException e) {
      throw e;
    } catch (IOException e) {
      throw new LicenseException("init License data fail", e);
    }
  }

  /**
   * 解密数据
   */
  public byte[] decrypt(byte[] data) {
    if (data == null) {
      return null;
    }
    byte[] resultData = BlackBox.decrypt(data);
    return resultData;
  }
}
