package org.bitcoinj.params;

import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.core.Utils;
import org.bitcoinj.net.discovery.HttpDiscovery;
import org.bitcoinj.params.AbstractBitcoinNetParams;

import java.net.URI;


public class HtmlCoinRegTestParams extends AbstractBitcoinNetParams {
    public static final int MAINNET_MAJORITY_WINDOW = 1000;
    public static final int MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED = 950;
    public static final int MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE = 750;

    public HtmlCoinRegTestParams() {
        super();
        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
        maxTarget = Utils.decodeCompactBits(0x1d00ffffL);
        dumpedPrivateKeyHeader = 239;
        addressHeader = 120;
        p2shHeader = 110;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        port = 4889;
        packetMagic = 0xf9beb4d9L;
        bip32HeaderPub = 0x043587CF; //The 4 byte header that serializes in base58 to "xpub".
        bip32HeaderPriv = 0x04358394; //The 4 byte header that serializes in base58 to "xprv"

        majorityEnforceBlockUpgrade = MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE;
        majorityRejectBlockOutdated = MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED;
        majorityWindow = MAINNET_MAJORITY_WINDOW;

        genesisBlock.setDifficultyTarget(0x207fffffL);
        genesisBlock.setTime(1506213200L);
        genesisBlock.setNonce(2);
        id = ID_HTML_REGTEST;
        subsidyDecreaseBlockCount = 210000;
        spendableCoinbaseDepth = 100;
        String genesisHash = genesisBlock.getHashAsString();
//        checkState(genesisHash.equals("000013694772f8aeb88efeb2829fe5d71fbca3e23d5043baa770726f204f528c"), genesisHash);

        checkpoints.put(0, Sha256Hash.wrap("000013694772f8aeb88efeb2829fe5d71fbca3e23d5043baa770726f204f528c"));

        dnsSeeds = new String[] {
        };
        httpSeeds = new HttpDiscovery.Details[] {

        };

        addrSeeds = new int[] {};
    }

    private static HtmlCoinRegTestParams instance;
    public static synchronized HtmlCoinRegTestParams get() {
        if (instance == null) {
            instance = new HtmlCoinRegTestParams();
        }
        return instance;
    }

    @Override
    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_MAINNET;
    }
}