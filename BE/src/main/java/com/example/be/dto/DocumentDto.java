package com.example.be.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class DocumentDto implements Validator {
    /**
     * Create by: TuanNDN
     * Date created: 29/03/2023
     */
    private Long documentId;
    @NotBlank(message = "Không được để trống, nhập tên tài liệu vào. ")
    private String documentName;
    @NotBlank(message = "Không được để trống, nhập mô tả cho tài liệu này vào. ")
    private String documentDescribe;
    private String documentFile;

    public DocumentDto() {
    }

    public DocumentDto(String documentName, String documentDescribe, String documentFile) {
        this.documentName = documentName;
        this.documentDescribe = documentDescribe;
        this.documentFile = documentFile;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentDescribe() {
        return documentDescribe;
    }

    public void setDocumentDescribe(String documentDescribe) {
        this.documentDescribe = documentDescribe;
    }

    public String getDocumentFile() {
        return documentFile;
    }

    public void setDocumentFile(String documentFile) {
        this.documentFile = documentFile;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
