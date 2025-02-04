package io.nop.cli.commands;

import io.nop.commons.concurrent.executor.GlobalExecutors;
import io.nop.core.resource.watch.FileWatcher;
import io.nop.core.resource.watch.NioFileWatchService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Singleton;

@Singleton
public class FileWatcherFactory {
    private NioFileWatchService watchService = new NioFileWatchService();

    @PostConstruct
    public void init() {
        watchService.start();
    }

    @PreDestroy
    public void destroy() {
        watchService.stop();
    }

    public FileWatcher newFileWatcher() {
        return new FileWatcher(watchService, GlobalExecutors.globalTimer());
    }
}