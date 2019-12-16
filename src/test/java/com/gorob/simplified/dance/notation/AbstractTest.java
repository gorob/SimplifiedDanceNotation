package com.gorob.simplified.dance.notation;

import lombok.AccessLevel;
import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public abstract class AbstractTest {
    @Getter(AccessLevel.PROTECTED)
    private TestModelCreator tmc;

    @Rule
    @Getter(AccessLevel.PRIVATE)
    public TemporaryFolder temporaryFolder = new TemporaryFolder(new File("./target"));

    @Before
    public void setUp(){
        this.tmc = new TestModelCreator();
    }

    protected File getTempRoot(){
        return getTemporaryFolder().getRoot();
    }

    protected File copyFolderToTemp(String resourceFolderPath, String targetFolderName) throws IOException {
        File sourceFolder = new File(getClass().getResource(resourceFolderPath).getFile());
        assertNotNull(sourceFolder);
        assertTrue(sourceFolder.isDirectory());
        File targetFolder = new File(getTempRoot(), targetFolderName);
        targetFolder.mkdirs();
        FileUtils.copyDirectory(sourceFolder, targetFolder);
        return targetFolder;
    }

    protected File copyToTemp(String resourceFilePath) throws IOException {
        File sourceFile = new File(getClass().getResource(resourceFilePath).getFile());
        assertNotNull(sourceFile);
        assertTrue(sourceFile.isFile());
        File targetFile = new File(getTempRoot(), sourceFile.getName());
        FileUtils.copyFile(sourceFile, targetFile);
        return targetFile;
    }
}
