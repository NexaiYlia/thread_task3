package com.nexai.task3.entity;

import com.nexai.task3.util.TerminalIdGenerator;

import java.util.StringJoiner;

public class Terminal {
    private final int terminalId;
    private volatile boolean isBusy = false;

    public Terminal(int terminalId) {
        this.terminalId = terminalId;
    }

    public Terminal(int terminalId, boolean isBusy) {
        this.terminalId = TerminalIdGenerator.generate();
        this.isBusy = isBusy;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public int getTerminalId() {
        return terminalId;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Terminal terminal = (Terminal) o;

        if (terminalId != terminal.terminalId) return false;
        return isBusy == terminal.isBusy;
    }

    @Override
    public int hashCode() {
        int result = terminalId;
        result = 31 * result + (isBusy ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Terminal.class.getSimpleName() + "[", "]")
                .add("terminalId=" + terminalId)
                .add("isBusy=" + isBusy)
                .toString();
    }
}
