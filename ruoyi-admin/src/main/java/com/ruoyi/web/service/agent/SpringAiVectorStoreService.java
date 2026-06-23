package com.ruoyi.web.service.agent;

import java.util.List;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import com.ruoyi.system.domain.agent.SysAgentKnowledgeChunk;

@Service
public class SpringAiVectorStoreService
{
    private final ObjectProvider<VectorStore> vectorStoreProvider;

    public SpringAiVectorStoreService(ObjectProvider<VectorStore> vectorStoreProvider)
    {
        this.vectorStoreProvider = vectorStoreProvider;
    }

    public boolean syncChunks(List<SysAgentKnowledgeChunk> chunks)
    {
        VectorStore vectorStore = vectorStoreProvider.getIfAvailable();
        if (vectorStore == null || chunks == null || chunks.isEmpty())
        {
            return false;
        }
        vectorStore.add(chunks.stream().map(this::toDocument).toList());
        return true;
    }

    private Document toDocument(SysAgentKnowledgeChunk chunk)
    {
        return Document.builder()
            .id(chunk.getVectorId())
            .text(chunk.getChunkText())
            .metadata("kbId", chunk.getKbId())
            .metadata("docId", chunk.getDocId())
            .metadata("chunkId", chunk.getChunkId())
            .metadata("fileName", chunk.getFileName())
            .metadata("kbName", chunk.getKbName())
            .build();
    }
}
