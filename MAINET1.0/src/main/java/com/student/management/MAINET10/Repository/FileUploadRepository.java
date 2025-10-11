package com.student.management.MAINET10.Repository;

import com.student.management.MAINET10.Entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<DocumentEntity, Long> {

}
