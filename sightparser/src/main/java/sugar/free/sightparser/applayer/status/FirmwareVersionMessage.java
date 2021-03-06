package sugar.free.sightparser.applayer.status;

import lombok.Getter;
import sugar.free.sightparser.applayer.AppLayerMessage;
import sugar.free.sightparser.applayer.Service;
import sugar.free.sightparser.error.SightError;
import sugar.free.sightparser.error.UnknownAppErrorCodeError;
import sugar.free.sightparser.pipeline.ByteBuf;

public class FirmwareVersionMessage extends AppLayerMessage {

    @Getter
    private String releaseSwVersion;
    @Getter
    private String uiProcSwVersion;
    @Getter
    private String pcProcSwVersion;
    @Getter
    private String mdTelProcSwVersion;
    @Getter
    private String btInfoPageVersion;
    @Getter
    private String safetyProcSwVersion;
    @Getter
    private short configIndex;
    @Getter
    private short historyIndex;
    @Getter
    private short stateIndex;
    @Getter
    private short vocabularyIndex;

    @Override
    public Service getService() {
        return Service.STATUS;
    }

    @Override
    public short getCommand() {
        return (short) 0xD82E;
    }

    @Override
    protected void parse(ByteBuf byteBuf) throws Exception {
        releaseSwVersion = byteBuf.readUTF8(14);
        uiProcSwVersion = byteBuf.readUTF8(12);
        pcProcSwVersion = byteBuf.readUTF8(12);
        mdTelProcSwVersion = byteBuf.readUTF8(12);
        btInfoPageVersion = byteBuf.readUTF8(12);
        safetyProcSwVersion = byteBuf.readUTF8(12);
        configIndex = byteBuf.readShortLE();
        historyIndex = byteBuf.readShortLE();
        stateIndex = byteBuf.readShortLE();
        vocabularyIndex = byteBuf.readShortLE();
    }
}
