package com.sparrowwallet.sparrow.terminal.wallet.table;

import com.sparrowwallet.sparrow.wallet.Entry;
import com.sparrowwallet.sparrow.wallet.TransactionEntry;
import com.sparrowwallet.sparrow.wallet.UtxoEntry;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateTableCell extends TableCell {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final int TRANSACTION_WIDTH = 23;
    public static final int UTXO_WIDTH = 18;

    public DateTableCell(Entry entry) {
        super(entry);
    }

    @Override
    public String formatCell() {
        if(entry instanceof TransactionEntry transactionEntry && transactionEntry.getBlockTransaction() != null) {
            if(transactionEntry.getBlockTransaction().getHeight() == -1) {
                return "Unconfirmed Parent";
            } else if(transactionEntry.getBlockTransaction().getHeight() == 0) {
                return "Unconfirmed";
            } else {
                return DATE_FORMAT.format(transactionEntry.getBlockTransaction().getDate());
            }
        } else if(entry instanceof UtxoEntry utxoEntry && utxoEntry.getBlockTransaction() != null) {
            if(utxoEntry.getBlockTransaction().getHeight() == -1) {
                return "Unconfirmed Parent";
            } else if(utxoEntry.getBlockTransaction().getHeight() == 0) {
                return "Unconfirmed";
            } else {
                return DATE_FORMAT.format(utxoEntry.getBlockTransaction().getDate());
            }
        }

        return "";
    }
}
