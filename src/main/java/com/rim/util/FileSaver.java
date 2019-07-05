package com.rim.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	public String saveFile(String realPath, MultipartFile multipartFile) throws Exception {

		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}

		// 저장할 파일명 생성
		// UUID 클래스 사용
		String fileSystemsName = UUID.randomUUID().toString();
		String originalName = multipartFile.getOriginalFilename();
		if (!originalName.equals("")) {
			originalName = originalName.substring(originalName.lastIndexOf("."));
			fileSystemsName += originalName;
			// 저장
			file = new File(realPath, fileSystemsName);
			multipartFile.transferTo(file);
		}else {
			fileSystemsName="";
		}

		return fileSystemsName;
	}
}
