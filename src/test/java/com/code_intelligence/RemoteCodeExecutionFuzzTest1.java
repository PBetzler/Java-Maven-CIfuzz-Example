package com.code_intelligence;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;

import java.io.ByteArrayInputStream;
import java.lang.Exception;

public class RemoteCodeExecutionFuzzTest1 {
    @FuzzTest
    public void myFuzzTest(FuzzedDataProvider data) {
        // Call the functions you want to test with the provided data and optionally
        // assert that the results are as expected.

        // If you want to know more about writing fuzz tests you can checkout the
        // example projects at https://github.com/CodeIntelligenceTesting/cifuzz/tree/main/examples
        // or have a look at our tutorial:
        // https://github.com/CodeIntelligenceTesting/cifuzz/blob/main/docs/How-To-Write-A-Fuzz-Test.md

        data.consumeString(512);
        try {
            RemoteCodeExecution.deserialize(new ByteArrayInputStream(data.consumeBytes(100)));
        } catch (Exception ignored) {
            // We can ignore all exception as the RCE will be caught by Jazzer
        }
    }
}