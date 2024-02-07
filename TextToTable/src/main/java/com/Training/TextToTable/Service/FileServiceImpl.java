package com.Training.TextToTable.Service;

import com.Training.TextToTable.Entity.User;
import com.Training.TextToTable.Repository.UserRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private UserRepository userRepo;
    @Override
    public boolean hasCSVFormat(MultipartFile file){
        String type = "txt";
        if (!type.equals(file.getContentType()) )
            return false;
        return true;
    }
    @Override
    public void processAndSaveData(MultipartFile file){
        try {
            List<User> users = csvToUser(file.getInputStream());
            userRepo.saveAll(users);
        }catch (IOException e){
            e.printStackTrace();
        }


    }
    private List<User> csvToUser(InputStream inputStream){
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());)
        {
            List<User> users = new ArrayList<User>();
            List<CSVRecord> records = csvParser.getRecords();
            for (CSVRecord csvRecord : records) {
                User user = new User(Integer.parseInt(csvRecord.get("Sno")), csvRecord.get("CourseName"),
                        csvRecord.get("Resources"), csvRecord.get("status"), csvRecord.get("comments"));
                users.add(user);
            }
            return users;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
